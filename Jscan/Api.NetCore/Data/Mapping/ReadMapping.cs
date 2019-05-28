using FluentNHibernate.Mapping;
using JscanMonitoringCore.Data.Model;

namespace JscanMonitoringCore.Data.Mapping
{
    /// <summary>
    /// Classe responsável por mapear os dados entre a Classe de leitura e a tabela de leitura do banco
    /// </summary>
    public class ReadMapping : ClassMap<Read>
    {
        public ReadMapping()
        {
            Table("TB_LEITURA_API");
            Id(c => c.Id).GeneratedBy.Identity().Unique().Column("idLeitura");
            Map(c => c.Active).Column("ATIVO");
            Map(c => c.Valid).Column("VALIDO");
            Map(c => c.ReadMoment).Column("DTREGISTRO");
            Map(c => c.IdApi).Column("IDAPI");
        }
    }
}
