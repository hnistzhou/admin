package com.gtja.app.operation.service.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoubo on 16/8/3.
 */
public class Transfer<Source, Target> {
    private Class sourceClazz;
    private Class targetClazz;

    public Transfer() {
        Type[] c = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        sourceClazz = (Class) c[0];
        targetClazz = (Class) c[1];
    }

    protected void convertExt(Source source, Target target) {

    }

    protected void reverseConvertExt(Target target, Source source) {
    }

    public List<Source> reverseConvert(List<Target> targetList) {
        if (CollectionUtils.isEmpty(targetList)) {
            return null;
        }
        List<Source> sourceList = new ArrayList<Source>(targetList.size());
        for (Target target : targetList) {
            Source source;
            try {
                source = (Source) sourceClazz.newInstance();

            } catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException();
            } catch (InstantiationException illegalAccessException) {
                throw new RuntimeException();
            }

            BeanUtils.copyProperties(target, source);
            reverseConvertExt(target, source);
            sourceList.add(source);
        }
        return sourceList;
    }

    public List<Target> convert(List<Source> sourceList) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return null;
        }
        List<Target> targetList = new ArrayList<Target>(sourceList.size());
        for (Source source : sourceList) {
            Target target;
            try {
                target = (Target) targetClazz.newInstance();
            } catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException();
            } catch (InstantiationException illegalAccessException) {
                throw new RuntimeException();
            }
            BeanUtils.copyProperties(source, target);
            convertExt(source, target);
            targetList.add(target);
        }
        return targetList;

    }

    public Target convert(Source source) {
        if (source == null) {
            return null;
        }
        Target target;
        try {
            target = (Target) targetClazz.newInstance();
        } catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException();
        } catch (InstantiationException illegalAccessException) {
            throw new RuntimeException();
        }
        BeanUtils.copyProperties(source, target);
        convertExt(source, target);
        return target;
    }

    public Source reverseConvert(Target target) {
        if (target == null) {
            return null;
        }
        Source source;
        try {
            source = (Source) sourceClazz.newInstance();
        } catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException();
        } catch (InstantiationException illegalAccessException) {
            throw new RuntimeException();
        }
        BeanUtils.copyProperties(target, source);
        reverseConvertExt(target, source);
        return source;
    }
}