package com.exams.filter;

import com.exams.entity.AppLocale;
import com.exams.i18n.ResourceBundleFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@WebFilter("/*")
public class LocaleFilter implements Filter {

    private Locale locale;
    private ResourceBundle messages;
    private List<AppLocale> locales = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        locales.add(new AppLocale("en", "en_lang.png"));
        locales.add(new AppLocale("ua", "ua_lang.png"));
        locale = new Locale(ResourceBundleFactory.LOCAL_DEFAULT);
        ResourceBundleFactory.setLocale(locale);
        messages = ResourceBundleFactory.getResourceBundle();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie ck[] = request.getCookies();
        if(ck != null){
            for(int i=0; i<ck.length; i++){
                if(ck[i].getName().equals("locale")){
                    Locale locale = new Locale(ck[i].getValue());
                    if(!locale.equals(this.locale)){
                        ResourceBundleFactory.setLocale(locale);
                        messages = ResourceBundleFactory.getResourceBundle();
                        this.locale = locale;
                    }
                }
            }
        }
        request.setAttribute("lang", locale.getLanguage());
        request.setAttribute("msg", messages);
        request.setAttribute("locales", locales);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
