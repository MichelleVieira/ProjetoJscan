using FluentNHibernate.Mapping;
using JscanMonitoringCore.Data.Model;

namespace JscanMonitoringCore.Data.Mapping
{
    public class ApiMapping : ClassMap<Api>
    {
        public ApiMapping()
        {
            Table("TB_API");
            Id(c => c.Id).GeneratedBy.Identity().Unique().Column("IDAPI");
            Map(c => c.Name).Column("NmApi");
            Map(c => c.EndPoint).Column("NmEndPoint");
            Map(c => c.Type).Column("idTipoApi");
        }
    }
}