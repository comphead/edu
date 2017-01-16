package org.cmpd.edu.assessmentbookapp.model;

import android.content.Context;
import android.net.Uri;

import org.cmpd.edu.assessmentbookapp.MVP;
import org.cmpd.edu.model.AssessmentAction;

import java.lang.ref.WeakReference;
import java.util.List;

public class AssessmentDownloadsModel
       implements MVP.ProvidedModelOps {
    /**
     * Debugging tag used by the Android logger.
     */
    protected final static String TAG =
            AssessmentDownloadsModel.class.getSimpleName();

    /**
     * A WeakReference used to access methods in the Presenter layer.
     * The WeakReference enables garbage collection.
     */
    private WeakReference<MVP.RequiredPresenterOps> mPresenter;

    /**
     * Hook method called when a new instance of AcronymModel is
     * created.  One time initialization code goes here, e.g., storing
     * a WeakReference to the Presenter and initializing the sync and
     * async Services.
     * 
     * @param presenter
     *            A reference to the Presenter layer.
     */
    @Override
    public void onCreate(MVP.RequiredPresenterOps presenter) {
        // Set the WeakReference.
        mPresenter =
            new WeakReference<>(presenter);
    }

    /**
     * Hook method called to shutdown the Model layer.
     *
     * @param isChangingConfigurations
     *        True if a runtime configuration triggered the onDestroy() call.
     */
    @Override
    public void onDestroy(boolean isChangingConfigurations) {
        // No-op.
    }

    @Override
    public List<AssessmentAction> downloadActions(Context context, Uri url) {
        return null;
    }
}
