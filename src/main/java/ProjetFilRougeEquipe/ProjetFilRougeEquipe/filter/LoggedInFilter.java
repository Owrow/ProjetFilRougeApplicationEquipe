package ProjetFilRougeEquipe.ProjetFilRougeEquipe.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import ProjetFilRougeEquipe.ProjetFilRougeEquipe.controller.CommandeRest;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.entities.Equipe;
import ProjetFilRougeEquipe.ProjetFilRougeEquipe.services.EquipeService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggedInFilter implements Filter {
	private static final int ROLE_ADMIN = 3;
	@Autowired private EquipeService eqService;
	private static final Logger log = LoggerFactory.getLogger(LoggedInFilter.class);
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;


//		chain.doFilter(request, response);
//		return;

		if ("/login".equals(httpReq.getServletPath())
				|| "OPTIONS".equals(httpReq.getMethod())) {
			chain.doFilter(request, response);
			return;
		}

		String auth = httpReq.getHeader("token");
		if (auth == null || auth.isBlank()) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}

		Equipe user = eqService.getByToken(auth);
		if (user == null) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
		} else {
			if(user.getRole().getId()==ROLE_ADMIN) {
				if ("/equipes".equals(httpReq.getServletPath()) || "/logout".equals(httpReq.getServletPath())) {
					chain.doFilter(request, response);
				} else {httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
				}
			}
			else {
				if (!"/equipes".equals(httpReq.getServletPath()) || "/logout".equals(httpReq.getServletPath())) {
				chain.doFilter(request, response);
			} else {httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			}
				
			}
		}

	}
}