package com.silence.service.impl;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * Created by Silence on 2019/7/23.
 */
public class Test {

    public static void main(String[] args) {

        try {
            Properties props = new Properties();

            props.put("python.import.site", "false");

            Properties preprops = System.getProperties();

            PythonInterpreter.initialize(preprops, props, new String[0]);

            PythonInterpreter pythonInterpreter = new PythonInterpreter();
            Resource resource = new ClassPathResource("add.py");
            String pathFile = resource.getFile().getPath();
            pythonInterpreter.execfile(pathFile);
            PyFunction pyFunction = pythonInterpreter.get("add", PyFunction.class);
            int a = 5;
            int b = 10;
            PyObject pyObject = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
            System.out.println(pyObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
