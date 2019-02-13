using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EJEMPLO_MVC_NET_P2.Startup))]
namespace EJEMPLO_MVC_NET_P2
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
