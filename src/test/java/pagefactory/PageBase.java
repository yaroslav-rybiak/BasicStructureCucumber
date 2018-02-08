package pagefactory;

import runner.TestRunner;

class PageBase extends TestRunner {

    String URL;
    public void open() {
        driver.get(URL);
    }

}
