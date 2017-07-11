package com.dijkstra.enums;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class NodeTypeTest {

    @Test
    public void shouldHaveAStartEnum() {
        assertThat(NodeType.START.toString(), is("START"));
    }

    @Test
    public void shouldHaveANodeEnum() {
        assertThat(NodeType.NODE.toString(), is("NODE"));
    }

    @Test
    public void shouldHaveAFinishEnum() {
        assertThat(NodeType.FINISH.toString(), is("FINISH"));
    }
}