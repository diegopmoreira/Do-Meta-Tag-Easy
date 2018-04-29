/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author diegomoreira
 */
public class App {

    public App() {
    }

    public void tableIO(Links link) {

        Document doc;
        String title = "empty";
        String keyword = "empty";
        String description = "empty";
        String url = "empty";
        try {
            url = link.getLink();
            doc = Jsoup.connect(url).get();
            Elements descriptions = doc.select("meta[name=description]");
            Elements keywords = doc.select("meta[name=keywords]");
            title = doc.title();
            keyword = keywords.attr("content");
            description = descriptions.attr("content");

        } catch (IOException ex) {
            title = "empty";
            keyword = "empty";
            description = "empty";
        } catch (IllegalArgumentException ex) {
            title = "empty";
            keyword = "empty";
            description = "empty";
        } finally {
            link.setDescription(description + ";");
            link.setKeyword(keyword+ ";");
            link.setTitle(title+ ";");
        }

    }

}
