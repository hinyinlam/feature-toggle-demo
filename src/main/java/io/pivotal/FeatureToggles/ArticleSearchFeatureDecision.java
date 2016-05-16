package io.pivotal.FeatureToggles;

import org.springframework.core.env.Environment;

/**
 * Created by hinlam on 16/5/2016.
 */

public class ArticleSearchFeatureDecision {

    private Boolean returnNonMemberArticle;
    private Boolean returnSensitiveWords;



    public boolean isArticleSearchReturnNonMemberArticle(){
        return this.returnNonMemberArticle;
    }


    public boolean isArticleSearchCleanSensitiveWords(){
        return this.returnSensitiveWords;
    }

    public ArticleSearchFeatureDecision(Environment env){
        this.returnNonMemberArticle = Boolean.parseBoolean(env.getProperty("Feature.ArticleSearch.ReturnNonmemberArticle"));
        if(this.returnNonMemberArticle==null){
            this.returnNonMemberArticle=false;
        }

        this.returnSensitiveWords = Boolean.parseBoolean(env.getProperty("Feature.ArticleSearch.CleanSensitiveWords"));
        if(this.returnSensitiveWords==null){
            this.returnSensitiveWords=false;
        }
    }

}
