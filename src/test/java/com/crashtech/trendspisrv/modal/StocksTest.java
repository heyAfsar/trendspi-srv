package com.crashtech.trendspisrv.modal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StocksTest {
	
	private Stocks stock;

	@BeforeEach
	void init() {
		stock = new Stocks("1", "Apple", 4, "2022-03-01", true, 100, false,
				"https://example.com/apple.jpg", "https://example.com/apple-thumb.jpg");
	}

	@Test
	@DisplayName("Test getId")
	void testGetId() {
		assertEquals("1", stock.getId());
	}

	@Test
	@DisplayName("Test getName")
	void testGetName() {
		assertEquals("Apple", stock.getName());
	}

	@Test
	@DisplayName("Test getStars")
	void testGetStars() {
		assertEquals(4, stock.getStars());
	}

	@Test
	@DisplayName("Test getDateModified")
	void testGetDateModified() {
		assertEquals("2022-03-01", stock.getDateModified());
	}

	@Test
	@DisplayName("Test getPopular")
	void testGetPopular() {
		assertEquals(true, stock.getPopular());
	}

	@Test
	@DisplayName("Test getLikes")
	void testGetLikes() {
		assertEquals(100, stock.getLikes());
	}

	@Test
	@DisplayName("Test getExpired")
	void testGetExpired() {
		assertEquals(false, stock.getExpired());
	}

	@Test
	@DisplayName("Test getImageURL")
	void testGetImageURL() {
		assertEquals("https://example.com/apple.jpg", stock.getImageURL());
	}

	@Test
	@DisplayName("Test getThumbnailURL")
	void testGetThumbnailURL() {
		assertEquals("https://example.com/apple-thumb.jpg", stock.getThumbnailURL());
	}

	@Test
	@DisplayName("Test setId")
	void testSetId() {
		stock.setId("2");
		assertEquals("2", stock.getId());
	}
	
	@Test
	@DisplayName("Test setName")
	void testSetName() {
		stock.setName("Google");
		assertEquals("Google", stock.getName());
	}

	@Test
	@DisplayName("Test setStars")
	void testSetStars() {
		stock.setStars(5);
		assertEquals(5, stock.getStars());
	}

	@Test
	@DisplayName("Test setDateModified")
	void testSetDateModified() {
		stock.setDateModified("2023-03-30");
		assertEquals("2023-03-30", stock.getDateModified());
	}

	@Test
	@DisplayName("Test setPopular")
	void testSetPopular() {
		stock.setPopular(false);
		assertEquals(false, stock.getPopular());
	}

	@Test
	@DisplayName("Test setLikes")
	void testSetLikes() {
		stock.setLikes(200);
		assertEquals(200, stock.getLikes());
	}

	@Test
	@DisplayName("Test setExpired")
	void testSetExpired() {
		stock.setExpired(true);
		assertEquals(true, stock.getExpired());
	}

	@Test
	@DisplayName("Test setImageURL")
	void testSetImageURL() {
		stock.setImageURL("https://example.com/google.jpg");
		assertEquals("https://example.com/google.jpg", stock.getImageURL());
	}

	@Test
	@DisplayName("Test setThumbnailURL")
	void testSetThumbnailURL() {
		stock.setThumbnailURL("https://example.com/google-thumb.jpg");
		assertEquals("https://example.com/google-thumb.jpg", stock.getThumbnailURL());
	}



}
