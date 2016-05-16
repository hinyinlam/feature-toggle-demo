package io.pivotal;

import io.pivotal.ArticleSearch.Searcher;
import io.pivotal.FeatureToggles.ArticleSearchFeatureDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController
@EnableWebMvc
public class FeatureToggleApplication{

	public static void main(String[] args) {
		SpringApplication.run(FeatureToggleApplication.class, args);
	}

	@Bean
	@Autowired
	public ArticleSearchFeatureDecision getArticleFeatureDecision(Environment env){
		return new ArticleSearchFeatureDecision(env);
	}

	@Autowired
	ArticleSearchFeatureDecision feature; //Spring framework will auto new ArticleSearchFeatureDecision() and put it here!

	//@Autowired
	//Environment env;

	@RequestMapping("/")
	public String home(){
		Searcher searcher = new Searcher(feature);
		String results= searcher.search("Keyword1, Keywoard2");

		return results;

	}

}
