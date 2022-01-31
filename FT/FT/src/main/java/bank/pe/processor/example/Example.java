/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package bank.pe.processor.example;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import org.apache.streampipes.model.runtime.Event;

public class Example implements FlatMapFunction<Event, Event> {

  private String exampleText;

  public Example(String exampleText) {
    this.exampleText = exampleText;
  }

  @Override
  public void flatMap(Event event, Collector<Event> out) {
    event.addField("appendedText", exampleText);
    out.collect(event);
  }
}
