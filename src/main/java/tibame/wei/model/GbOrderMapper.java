package tibame.wei.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.MappedJdbcTypes;

@Mapper
public interface GbOrderMapper {
    @Select("selectGbMember")
    List<GbOrderResult> selectGbMember(Integer p_m_id, Integer gb_p_id);
}


