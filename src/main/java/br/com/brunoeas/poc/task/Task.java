package br.com.brunoeas.poc.task;

import br.com.brunoeas.poc.common.enums.IndicatorYesNoEnum;
import br.com.brunoeas.poc.common.enums.IndicatorYesNoEnumConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TASK")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TASK")
    private Long id;

    @Column(name = "TX_NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "TX_DESCRIPTION", length = 300)
    private String description;

    @Convert(converter = TaskStatusEnumConverter.class)
    @Column(name = "CD_STATUS", nullable = false)
    private TaskStatusEnum status;

    @Convert(converter = IndicatorYesNoEnumConverter.class)
    @Column(name = "IN_PUBLIC_TASK", nullable = false)
    private IndicatorYesNoEnum indicatorPublic;

}
