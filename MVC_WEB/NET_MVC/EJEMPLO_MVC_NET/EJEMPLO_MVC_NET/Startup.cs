using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EJEMPLO_MVC_NET.Startup))]
namespace EJEMPLO_MVC_NET
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
