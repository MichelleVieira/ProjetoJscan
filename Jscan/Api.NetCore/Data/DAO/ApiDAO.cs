using JscanMonitoringCore.Data.Config;
using JscanMonitoringCore.Data.Model;
using NHibernate;

namespace JscanMonitoringCore.Data.DAO
{
    /// <summary>
    /// Classe responsável pelos CRUDS de leitura de dados (no caso, apenas inserir)
    /// </summary>
    public class ApiDAO : IDAO<Api>
    {
        public void Insert(Api obj)
        {
            using (ISession session = SessionFactory.OpenSession())
            using (ITransaction transaction = session.BeginTransaction())
            {
                session.Save(obj);

                transaction.Commit();
            }
        }

        public Api Get(int id)
        {
            using (ISession session = SessionFactory.OpenSession())
            {
                return session.Get<Api>(id);
            }
        }
    }
}