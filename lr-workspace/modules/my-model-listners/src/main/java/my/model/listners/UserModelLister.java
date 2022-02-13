package my.model.listners;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

/**
 * @author Danish
 */

@Component(service= ModelListener.class)
public class UserModelLister extends BaseModelListener<User>{

	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("UserModelLister.onAfterAddAssociation()");
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("UserModelLister.onAfterCreate()");
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(User model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemove(model);
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onAfterRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterUpdate(User model) throws ModelListenerException {
		// TODO Auto-generated method stub
		System.out.println("UserModelLister.onAfterUpdate()");
		super.onAfterUpdate(model);
	}

	@Override
	public void onBeforeAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeCreate(User model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(User model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemove(model);
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(User model) throws ModelListenerException {
		// TODO Auto-generated method stub
		super.onBeforeUpdate(model);
	}

	
	

}