/*
Copyright 2014 Paul Sidnell

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.psidnell.omnifocus.visitor;

import java.util.List;
import java.util.stream.Collectors;

import org.psidnell.omnifocus.model.Context;
import org.psidnell.omnifocus.model.Folder;
import org.psidnell.omnifocus.model.Project;
import org.psidnell.omnifocus.model.Task;

public interface Visitor {
    
    default void enter(Folder node) throws Exception {
    }

    default void exit(Folder node) throws Exception {
    }
    
    default void enter(Task node) throws Exception {
    }

    default void exit(Task node) throws Exception {
    }

    default void enter(Context node) throws Exception {
    }

    default void exit(Context node) throws Exception {
    }

    default void enter(Project node) throws Exception {
    }

    default void exit(Project node) throws Exception {
    }

    default List<Folder> filterFoldersUp(List<Folder> folders) {
        return folders.stream().filter((p)->includeUp(p)).collect(Collectors.toList());
    }

    default List<Project> filterProjectsUp(List<Project> projects) {
        return projects.stream().filter((p)->includeUp(p)).collect(Collectors.toList());
    }

    default List<Context> filterContextsUp(List<Context> contexts) {
        return contexts.stream().filter((p)->includeUp(p)).collect(Collectors.toList());
    }

    default List<Task> filterTasksUp(List<Task> tasks) {
        return tasks.stream().filter((p)->includeUp(p)).collect(Collectors.toList());
    }
    
    default List<Folder> filterFoldersDown(List<Folder> folders) {
        return folders.stream().filter((p)->includeDown(p)).collect(Collectors.toList());
    }

    default List<Project> filterProjectsDown(List<Project> projects) {
        return projects.stream().filter((p)->includeDown(p)).collect(Collectors.toList());
    }

    default List<Context> filterContextsDown(List<Context> contexts) {
        return contexts.stream().filter((p)->includeDown(p)).collect(Collectors.toList());
    }

    default List<Task> filterTasksDown(List<Task> tasks) {
        return tasks.stream().filter((p)->includeDown(p)).collect(Collectors.toList());
    }
    
    default boolean includeUp (Project p) {
        return true;
    }
    
    default boolean includeUp (Task t) {
        return true;
    }
    
    default boolean includeUp (Folder f) {
        return true;
    }
    
    default boolean includeUp (Context c) {
        return true;
    }
    
    default boolean includeDown (Project p) {
        return true;
    }
    
    default boolean includeDown (Task t) {
        return true;
    }
    
    default boolean includeDown (Folder f) {
        return true;
    }
    
    default boolean includeDown (Context c) {
        return true;
    }
}