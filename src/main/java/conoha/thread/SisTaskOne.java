package conoha.thread;

import conoha.utils.SisUtils;
import org.jsoup.nodes.Element;

public class SisTaskOne implements Runnable {
    private Element element;

    public SisTaskOne(Element element) {
        this.element = element;
    }

    public void run() {
        SisUtils.getMovieDetails(element);
    }
}