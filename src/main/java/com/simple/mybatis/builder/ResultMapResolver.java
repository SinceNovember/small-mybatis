package com.simple.mybatis.builder;

import com.simple.mybatis.mapping.ResultMap;
import com.simple.mybatis.mapping.ResultMapping;

import java.util.List;

/**
 * 结果映射解析器
 *
 * @author SinceNovember
 * @date 2022/10/16
 */
public class ResultMapResolver {

    private final MapperBuilderAssistant assistant;
    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;

    public ResultMapResolver(MapperBuilderAssistant assistant, String id, Class<?> type, List<ResultMapping> resultMappings) {
        this.assistant = assistant;
        this.id = id;
        this.type = type;
        this.resultMappings = resultMappings;
    }

    public ResultMap resolve() {
        return assistant.addResultMap(this.id, this.type, this.resultMappings);
    }
}
