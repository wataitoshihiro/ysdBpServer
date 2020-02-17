package io.pivotal.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestOperations;

public class InvoiceClient {
    private static Logger logger = LoggerFactory.getLogger(InvoiceClient.class);
    private String albumsUrl;
    private RestOperations restOperations;

    public InvoiceClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public Invoice find(Integer invoiceNumber) {
//        logger.debug("albumsUrl[{}]", albumsUrl);
        logger.debug("albumsUrl[{}{}{}]", albumsUrl, "/", invoiceNumber);
        return restOperations.getForEntity(albumsUrl + "/" + invoiceNumber, Invoice.class).getBody();
//        return restOperations.getForEntity("http://localhost:2222/time-entries" + "/" + id, TimeEntry.class).getBody();
    }

//    public void addAlbum(AlbumInfo album) {
//        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
//    }
//
//    public AlbumInfo find(long id) {
//        return restOperations.getForEntity(albumsUrl + "/" + id, AlbumInfo.class).getBody();
//    }
//
//    public List<AlbumInfo> getAlbums() {
//        ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
//        };
//
//        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
//    }
}
