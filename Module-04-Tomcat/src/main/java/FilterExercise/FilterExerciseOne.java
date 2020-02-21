package FilterExercise;

import javax.servlet.*;     /*注意一定是javax.servlet下的包*/
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/*Filter的3个步骤：
* 1.定义Filter类并实现Filter
* 2.override
* 3.配置xml或注解*/                          /*关于REQUEST：当浏览器直接请求该资源时会触发过滤器（转发FORWARD则不会）*/
@WebFilter(value = {/*"/*",*/"/forward"},dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})        /*表示所有路径都会经过filter*/
public class FilterExerciseOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*进入filter后会先执行doFilter下的内容*/
        System.out.println("filter done!!");

        /*然后进行放行*/
        filterChain.doFilter(servletRequest,servletResponse);




    }

    @Override
    public void destroy() {

    }
}
