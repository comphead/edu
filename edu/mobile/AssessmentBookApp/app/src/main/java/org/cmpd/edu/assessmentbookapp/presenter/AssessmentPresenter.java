package org.cmpd.edu.assessmentbookapp.presenter;

import android.content.Context;
import android.net.Uri;

import org.cmpd.edu.assessmentbookapp.MVP;
import org.cmpd.edu.assessmentbookapp.R;
import org.cmpd.edu.assessmentbookapp.common.GenericPresenter;
import org.cmpd.edu.assessmentbookapp.common.GenericSingleton;
import org.cmpd.edu.assessmentbookapp.integration.AssessmentAPI;
import org.cmpd.edu.assessmentbookapp.integration.GenericRetrofitService;
import org.cmpd.edu.assessmentbookapp.integration.RetrofitClient;
import org.cmpd.edu.assessmentbookapp.model.AssessmentDownloadsModel;
import org.cmpd.edu.model.AssessmentAction;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * This class defines all the image-related operations.  It implements
 * the various Ops interfaces so it can be created/managed by the
 * GenericActivity framework.  It plays the role of the "Abstraction"
 * in Bridge pattern and the role of the "Presenter" in the
 * Model-View-Presenter pattern.
 */
public class AssessmentPresenter
       extends GenericPresenter<MVP.RequiredPresenterOps,
                                       MVP.ProvidedModelOps,
                                       AssessmentDownloadsModel>
       implements MVP.ProvidedPresenterOps,
                  MVP.RequiredPresenterOps {
    /**
     * Used to enable garbage collection.
     */
    private WeakReference<MVP.RequiredViewOps> mView;
    private Retrofit client;

    /**
     * Constructor will choose either the Started Service or Bound
     * Service implementation of AssessmentPresenter.
     */
    public AssessmentPresenter() {
        client = GenericSingleton.instance(RetrofitClient.class)
                .getInstance(this.getApplicationContext().getString(R.string.view_server));
    }

    /**
     * Hook method called when a new instance of AcronymPresenter is
     * created.  One time initialization code goes here, e.g., storing
     * a WeakReference to the View layer and initializing the Model
     * layer.
     * 
     * @param view
     *            A reference to the View layer.
     */
    @Override
    public void onCreate(MVP.RequiredViewOps view) {
        // Set the WeakReference.
        mView = new WeakReference<>(view);

        // Finish the initialization steps.
        resetFields();

        // Invoke the special onCreate() method in GenericPresenter,
        // passing in the ImageDownloadsModel class to instantiate/manage and
        // "this" to provide ImageDownloadsModel with this MVP.RequiredModelOps
        // instance.
        super.onCreate(AssessmentDownloadsModel.class,
                       this);
    }

    /**
     * Hook method dispatched by the GenericActivity framework to
     * initialize the AssessmentPresenter object after a runtime
     * configuration change.
     *
     * @param view         The currently active AssessmentPresenter.View.
     */
    @Override
    public void onConfigurationChange(MVP.RequiredViewOps view) {
        // Reset the mView WeakReference.
        mView = new WeakReference<>(view);

    }

    /**
     * Hook method called to shutdown the Presenter layer.
     *
     * @param isChangingConfigurations
     *        True if a runtime configuration triggered the onDestroy() call.
     */
    @Override
    public void onDestroy(boolean isChangingConfigurations) {
        // Destroy the model.
        getModel().onDestroy(isChangingConfigurations);
    }

    /**
     * Reset the URL and counter fields and redisplay linear layout.
     */
    private void resetFields() {
    }
        
    /**
     * Perform the download and filter processing.  
     */
    @Override
    public void startProcessing() {
        GenericRetrofitService<AssessmentAPI> service = new GenericRetrofitService(client);
        Call<List<AssessmentAction>> call = service.getInstance().getAssessmentActions();
        call.enqueue(new Callback<List<AssessmentAction>>() {
            @Override
            public void onResponse(Call<List<AssessmentAction>> call, Response<List<AssessmentAction>> response) {

            }

            @Override
            public void onFailure(Call<List<AssessmentAction>> call, Throwable t) {
                mView.get().reportRequestFailure(t);
            }
        });
    }

    /**
     * Interact with the View layer to display the downloaded images
     * when they are all returned from the Model.
     */
    @Override
    public void onProcessingComplete(Uri url,
                                     Uri pathToImageFile) {
    }

    /**
     * Returns true if all the downloads have completed, else false.
     */


    /**
     * Returns true if there are any downloads in progress, else false.
     */

    /**
     * Return the Activity context.
     */
    @Override
    public Context getActivityContext() {
        return mView.get().getActivityContext();
    }
    
    /**
     * Return the Application context.
     */
    @Override
    public Context getApplicationContext() {
        return mView.get().getApplicationContext();
    }
}
