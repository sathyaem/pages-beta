package org.dell.kube.pages;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class PageController {

    private IPageRepository pageRepository;

    Logger logger =(Logger)LoggerFactory.getLogger(this.getClass());

    public PageController(IPageRepository pageRepository)
    {
        this.pageRepository = pageRepository;
    }

    @PostMapping
    public ResponseEntity<Page> create(@RequestBody Page page) {
        Page newPage= pageRepository.create(page);
        logger.info("***Creating a new page***");
        logger.debug("***Creating a new page***");
        return new ResponseEntity<Page>(newPage, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Page> read(@PathVariable long id) {
        Page page = pageRepository.read(id);
        if(page!=null)
            return new ResponseEntity<Page>(page, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Page>> list() {
        List<Page> pages= pageRepository.list();
        logger.info("***Retrieving list of pages***");
        logger.debug("***Retrieving list of pages***");
        return new ResponseEntity<List<Page>>(pages, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Page> update(@RequestBody Page page, @PathVariable long id) {
        Page updatedPage= pageRepository.update(page,id);
        if(updatedPage!=null)
            return new ResponseEntity<Page>(updatedPage, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        pageRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
