package io.pivotal.ArticleSearch;

import io.pivotal.FeatureToggles.ArticleSearchFeatureDecision;

import java.util.ArrayList;

/**
 * Created by hinlam on 16/5/2016.
 */
public class Searcher {

    private ArticleSearchFeatureDecision feature = null;

    public Searcher(ArticleSearchFeatureDecision feature){
        this.feature = feature;
    }

    public String search(String keywords){
        ArrayList<String> articleIds = new ArrayList<String>();
        if(feature.isArticleSearchReturnNonMemberArticle()){
            articleIds.add("Non member article here!");
        }else{
            articleIds.add("Member article here!");
        }

        if(feature.isArticleSearchCleanSensitiveWords()){
            articleIds.add("I cleaned up all sensitive words!");
        }else{
            articleIds.add("has sensitive words!");
        }
        return articleIds.toString();
    }
}
