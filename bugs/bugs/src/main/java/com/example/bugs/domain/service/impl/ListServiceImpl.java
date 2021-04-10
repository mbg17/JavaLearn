package .service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ..List;
import .service.ListService;
import .mapper.ListMapper;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class ListServiceImpl extends ServiceImpl<ListMapper, List>
implements ListService{

}
