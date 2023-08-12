package tibame.wei.proOrderController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tibame.wei.model.GbOrderMapper;
import tibame.wei.model.GbOrderResult;

@RestController
@RequestMapping("/backEnd")
public class GbInfoController {

    @Autowired
    private GbOrderMapper gbOrderMapper;
    
    @PostMapping("/gb-memberList")
    public List<GbOrderResult> selectGbMember(Integer p_m_id, Integer gb_p_id) {
        return gbOrderMapper.selectGbMember(p_m_id, gb_p_id);
    }
}

