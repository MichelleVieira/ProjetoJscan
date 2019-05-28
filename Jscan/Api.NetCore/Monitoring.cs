using JscanMonitoringCore.ClassBody;
using JscanMonitoringCore.Data.DAO;
using JscanMonitoringCore.Data.Model;
using System;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;

namespace JscanMonitoringCore
{
    class Monitoring
    {
        private static ReadDAO _newRead;

        static async Task Main()
        {
            // Api apiToInsert = new Api{
            //     Name = "",
            //     EndPoint = "",
            //     Type = 1 || 2
            // };

            // new ApiDAO().Insert(apiToInsert);

           ApiDAO getApi = new ApiDAO();

            var api = getApi.Get(1);

            Console.WriteLine("API BUSCADA: " +api.Name+"\n");

            await MonitoringApi(api , new Correios());
        }

        static async Task MonitoringApi(Api api, BaseBody @base)
        {
            _newRead = new ReadDAO();
            int minute = 60000;
            HttpResponseMessage response;

            using (HttpClient client = new HttpClient())
            {
                try
                {
                    while (true)
                    {
                        response = await client.GetAsync(api.EndPoint);//Faz a requisição

                        @base.ValidateStatusCode(response.StatusCode);//Valida o status code retornado da requisição

                        if (@base.IsOnline)
                        {
                            Console.WriteLine("API Online!");
                        }
                        else
                        {
                            Console.WriteLine("API Offline :(");
                        }

                        @base.ValidateResponseBody(await response.Content.ReadAsStringAsync());//Valida o corpo da requisição

                        if (@base.IsValid)
                        {
                            Console.WriteLine("Resposta da API validada!");
                        }
                        else
                        {
                            Console.WriteLine("Resposta da API ínvalida! :(");
                        }

                        //Instanciando um novo objeto de leitura
                        Read read = new Read
                        {
                            Active = @base.IsOnline,
                            Valid = @base.IsValid,
                            ReadMoment = DateTime.Now,
                            IdApi = api.Id
                        };

                        //Inserindo a leitura no banco
                        _newRead.Insert(read);

                        Thread.Sleep(minute);//Tempo de delay de monitoramento, a validar.
                        //ACRESCENTAR TIMER AO INVES DE THREAD.SLEEP

                        Console.WriteLine("");//Quebra de linha para o próximo monitoramento
                    }
                }
                catch (HttpRequestException e)
                {
                    //tratamento de exceção
                    Console.WriteLine("\nOcorreu uma exceção!");
                    Console.WriteLine("Mensagem :{0} ", e.Message);
                }
            }
        }
    }
}
