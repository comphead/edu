package org.cmpd.edu.assessmentbookapp.view;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import org.cmpd.edu.assessmentbookapp.MVP;
import org.cmpd.edu.assessmentbookapp.R;
import org.cmpd.edu.assessmentbookapp.common.GenericActivity;
import org.cmpd.edu.assessmentbookapp.common.Utils;
import org.cmpd.edu.assessmentbookapp.presenter.AssessmentPresenter;

public class DownloadAssessmentActionsActivity
        extends GenericActivity<MVP.RequiredViewOps,
        MVP.ProvidedPresenterOps,
        AssessmentPresenter>
        implements MVP.RequiredViewOps {
    /**
     * EditText field for entering the desired URL to an image.
     */
    protected EditText mUrlEditText;

    /**
     * Linear layout to store TextViews displaying URLs.
     */
    protected LinearLayout mLinearLayout;

    /**
     * Display progress to the user.
     */
    protected ProgressBar mLoadingProgressBar;

    /**
     * Menu on main screen
     */
    protected Menu mServiceMenu;

    /**
     * Hook method called when a new instance of Activity is created.
     * One time initialization code goes here, e.g., UI layout
     * initialization and initializing the GenericActivity framework.
     *
     * @param savedInstanceState Object that contains saved state information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Perform first part of initializing the super class.
        super.onCreate(savedInstanceState);

        // Set the default layout.
        setContentView(R.layout.activity_download_assessment);

        // (Re)initialize all the View fields.
        initializeViewFields();

        // Perform second part of initializing the super class,
        // passing in the AssessmentPresenter class to instantiate/manage
        // and "this" to provide AssessmentPresenter with the
        // MVP.RequiredViewOps instance.
        super.onCreate(AssessmentPresenter.class,
                this);
    }

    /**
     * Hook method called by Android when this Activity becomes
     * invisible.
     */
    @Override
    protected void onDestroy() {
        // Destroy the presenter layer, passing in whether this is
        // triggered by a runtime configuration or not.
        getPresenter().onDestroy(isChangingConfigurations());

        // Always call super class for necessary operations when
        // stopping.
        super.onDestroy();
    }

    /**
     * Initialize the View fields.
     */
    private void initializeViewFields() {
    }

    /**
     * Called by the Android Activity framework when the user presses
     * the "Download" button in the UI.
     *
     * @param view The view.
     */
    public void downloadImages(View view) {
        getPresenter().startProcessing();
    }

    @Override
    public void reportRequestFailure(Uri url, boolean processComplete) {
        Utils.showToast(this,
                "image at "
                        + url.toString()
                        + " failed to download!");
    }

    @Override
    public void displayResults(Uri directoryPathname) {
    }
}
