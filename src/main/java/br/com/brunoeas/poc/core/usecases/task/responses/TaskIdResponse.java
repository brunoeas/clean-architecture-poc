package br.com.brunoeas.poc.core.usecases.task.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class TaskIdResponse implements Serializable {

    private Long taskId;

}
