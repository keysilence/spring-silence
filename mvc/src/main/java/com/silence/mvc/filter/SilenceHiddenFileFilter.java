package com.silence.mvc.filter;

import org.apache.commons.io.filefilter.HiddenFileFilter;

import java.io.File;

/**
 * 1.此类作用是过滤掉隐藏文件；
 * 2.其父类的作用是只罗列隐藏文件；
 */
public class SilenceHiddenFileFilter extends HiddenFileFilter {

    public SilenceHiddenFileFilter() {
        super();
    }

    @Override
    public boolean accept(File file) {
        return !file.isHidden();
    }

}
