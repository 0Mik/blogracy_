package it.unipr.aotlab.blogracy.web;

import org.junit.Assert;
import org.junit.Test;

/**
 * Enrico Franchi, 2011 (c)
 * <p/>
 * This program or module is released under the terms of the MIT license.
 * <p/>
 * User: enrico
 * Date: 11/2/11
 * Time: 12:01 PM
 */
public class URLMapperTest {
    private URLMapper mapper;

    @org.junit.Before
    public void setUp() throws Exception {
        mapper = new URLMapper();
        mapper.configure(
                "/profile/", "it.unipr.aotlab.blogracy.web.FakeProfile",
                "/messages/", "it.unipr.aotlab.blogracy.web.FakeMessages"
        );
    }

    @Test
    public void testIrrelevantTrailingSlash() throws Exception {
        RequestResolver withSlash = mapper.getResolver("/profile/");
        RequestResolver withoutSlash = mapper.getResolver("/profile");

        Assert.assertSame(withoutSlash, withSlash);
    }
}
