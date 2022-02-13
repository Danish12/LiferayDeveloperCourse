package my.global.properties;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(property = { "language.id=en_US" }, service = ResourceBundle.class)
public class USGlobalResourceBundle extends ResourceBundle {

	@Override
	protected Object handleGetObject(String key) {
		return bundle.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return bundle.getKeys();
	}

	private ResourceBundle bundle = 
			ResourceBundle.getBundle("content.Language_en_US", UTF8Control.INSTANCE);
}
