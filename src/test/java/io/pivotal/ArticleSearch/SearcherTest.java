package io.pivotal.ArticleSearch;

import io.pivotal.FeatureToggleApplication;
import io.pivotal.FeatureToggles.ArticleSearchFeatureDecision;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertTrue;

/**
 * Created by hinlam on 16/5/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FeatureToggleApplication.class)
@WebAppConfiguration
public class SearcherTest {

    @Test
    public void memberArticleExistsWhenReturnNonmemberArticleIsTrue(){
        MockEnvironment env = new MockEnvironment();
        env.setProperty("Feature.ArticleSearch.ReturnNonmemberArticle", "true");

        ArticleSearchFeatureDecision feature = new ArticleSearchFeatureDecision(env);
        Searcher searcher = new Searcher(feature);

        String result = searcher.search("keyword1, keyword2");
        assertTrue(result.indexOf("Non member article here!")!=-1);
        //assertFalse(result.indexOf("Member article here!")!=-1);
    }

    @Test
    public void senitiveWordsShouldBeCleanedWhenCleanSensitiveWordsIsTrue() {
        MockEnvironment env = new MockEnvironment();
        env.setProperty("Feature.ArticleSearch.CleanSensitiveWords", "true");

        ArticleSearchFeatureDecision feature = new ArticleSearchFeatureDecision(env);
        Searcher searcher = new Searcher(feature);

        String result = searcher.search("keyword1, keyword2");
        assertTrue(result.indexOf("I cleaned up all sensitive words!")!=-1);
        //assertFalse(result.indexOf("has sensitive words!")!=-1);
    }

}
