package com.huang.alpha.entity;


import com.huang.alpha.constants.ConstantsTable;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = ConstantsTable.THREADS)
public class Threads {

    @Column(name="thread_id")
    private String  threadId;
    @Column(name="name")
    private String  name;
    @Column(name="type")
    private String type;
    @Column(name="processlist_command")
    private String processlistCommand;
    @Column(name="connection_type")
    private String connectionTye;


    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcesslistCommand() {
        return processlistCommand;
    }

    public void setProcesslistCommand(String processlistCommand) {
        this.processlistCommand = processlistCommand;
    }

    public String getConnectionTye() {
        return connectionTye;
    }

    public void setConnectionTye(String connectionTye) {
        this.connectionTye = connectionTye;
    }
}
