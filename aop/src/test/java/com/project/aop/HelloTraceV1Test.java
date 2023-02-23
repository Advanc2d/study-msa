package com.project.aop;

import org.junit.jupiter.api.Test;

import com.project.aop.trace.TraceStatus;
import com.project.aop.trace.hellotrace.HelloTraceV1;

class HelloTraceV1Test {

	@Test
	void begin_end() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}

	@Test
	void begin_exception() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.exception(status, new IllegalStateException());
	}

}
