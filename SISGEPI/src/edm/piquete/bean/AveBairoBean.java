package edm.piquete.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edm.piquete.modelo.AveBairo;

@Controller("aveBairoBean")
@Scope("session")
public class AveBairoBean implements Serializable{

	private static final long serialVersionUID = -5275054901424706302L;

	/*private AveBairo aveBairo;
	private List<AveBairo> aveBairos;*/
}
