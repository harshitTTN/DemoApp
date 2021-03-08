/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mysite.core.servlets;

import com.mysite.core.services.ClassServiceConfiguration;
import com.mysite.core.services.Student;
import com.mysite.core.services.StudentClassService;
import com.mysite.core.services.StudentClassValidatorService;

import java.util.Arrays;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */

@Component(service = { Servlet.class },immediate = true)
@SlingServletPaths(value = "/bin/myservlet")
public class SimpleServlet extends SlingSafeMethodsServlet {


    
    @Reference
    private StudentClassValidatorService studentClassValidatorService;
    @Reference
    private StudentClassService studentClassService;
    @Override
    public void init() throws ServletException {
        studentClassService.addStudent(new Student(1, "Harshit", 100));
        studentClassService.addStudent(new Student(2, "John", 90));
        studentClassService.addStudent(new Student(3, "Ram", 55));
        studentClassService.addStudent(new Student(4, "Lakhan", 40));

    }
    
    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        int id,marks;
        String name;
        int choice = Integer.parseInt(req.getParameter("Choice"));
        switch(choice){
            case 1 :
                resp.getWriter().println("First List  :" + studentClassService.getAllStudent());
                id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");

                marks = Integer.parseInt(req.getParameter("marks"));
                studentClassService.addStudent(new Student(id,name,marks));
                resp.getWriter().println("Student added");
                resp.getWriter().println("Modified List:" +studentClassService.getAllStudent());
                break;
            case 2 :

                resp.getWriter().println("List of student :" +studentClassService.getAllStudent());
                break;

            case 3 : resp.getWriter().println("First List :" + studentClassService.getAllStudent());
                id = Integer.parseInt(req.getParameter("id"));
                resp.getWriter().println("Student info with given id  :" +studentClassService.getStudent(id));
                break;

            case 4 :  resp.getWriter().println("First List :" + studentClassService.getAllStudent());
                id = Integer.parseInt(req.getParameter("id"));
                studentClassService.deleteStudent(id);
                resp.getWriter().println("Student deleted");
                resp.getWriter().println("Modified List :" +studentClassService.getAllStudent());
                break;

            case 5:
                resp.getWriter().println("LIST INITIALLY  :" + studentClassService.getAllStudent());
                id = Integer.parseInt(req.getParameter("id"));
                resp.getWriter().println("Is the student with given id passed : "+studentClassService.isStudentPassed(id));
                break;

            case 6 :   resp.getWriter().println("Passing marks : "+ studentClassValidatorService.getPassingMarks());
                break;

            default: resp.getWriter().println("Enter a valid choice");
        }

        }
}
