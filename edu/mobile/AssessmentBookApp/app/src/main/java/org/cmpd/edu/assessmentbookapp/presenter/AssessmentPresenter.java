package org.cmpd.edu.assessmentbookapp.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

import org.cmpd.edu.assessmentbookapp.MVP;
import org.cmpd.edu.assessmentbookapp.common.GenericPresenter;
import org.cmpd.edu.assessmentbookapp.model.AssessmentDownloadsModel;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    	
    /**
     * Stores the running total number of images downloaded that must
     * be handled by ServiceResultHandler.
     */
    private int mNumImagesToHandle;
    
    /**
     * Stores the running total number of images that have been
     * handled by the ServiceResultHandler.
     */
    private int mNumImagesHandled;
    
    /**
     * Stores the directory to be used for all downloaded images.
     */
    private Uri mDirectoryPathname = null;
    
    /**
     * Array of Strings that represent the valid URLs that have
     * been entered.
     */
    private ArrayList<Uri> mUrlList;

    private android.os.Handler mHandler;

    /**
     * Constructor will choose either the Started Service or Bound
     * Service implementation of AssessmentPresenter.
     */
    public AssessmentPresenter() {

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

        // Create a timestamp that will be unique.
        final String timestamp =
            new SimpleDateFormat("yyyyMMdd'_'HHmm").format(new Date());

        // Use the timestamp to create a pathname for the
        // directory that stores downloaded images.
        mDirectoryPathname = 
            Uri.parse(Environment.getExternalStoragePublicDirectory
                      (Environment.DIRECTORY_DCIM)
                      + "/" 
                      + timestamp 
                      + "/");
        
        // Initialize the list of URLs.
        mUrlList = new ArrayList<Uri>();

        mHandler = new android.os.Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message inputMessage) {
                switch (inputMessage.what) {
                    case 1 :
                        Pair<Uri, Uri> pair = (Pair<Uri, Uri>) inputMessage.obj;
                        onProcessingComplete(pair.first, pair.second);
                        break;
                    default :
                        super.handleMessage(inputMessage);
                }
            }
        };


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
    private boolean allDownloadsComplete() {
        return mNumImagesHandled == mNumImagesToHandle
            && mNumImagesHandled > 0;
    }

    /**
     * Returns true if there are any downloads in progress, else false.
     */
    private boolean downloadsInProgress() {
        return mNumImagesToHandle > 0;
    }

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
