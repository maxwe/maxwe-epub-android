package org.maxwe.epub.android.lib;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.model.EPub;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

        EPubManager ePubManager = new EPubManager(this.getApplication().getApplicationContext(), new EPub("test", "/sdcard/YMEPub/sample.zip"), new EPubManager.OnEPubManageListener() {
            @Override
            public void onBookNotExists(IBook ePub) {
                System.out.println();
            }

            @Override
            public void onMakeEPubDirFail(IBook ePub) {
                System.out.println();
            }

            @Override
            public void onUnzipEPubError(IBook ePub, Exception exception) {
                System.out.println();
            }

            @Override
            public void onSuccess(IBook ePub) {
                System.out.println();
            }
        });

    }
}