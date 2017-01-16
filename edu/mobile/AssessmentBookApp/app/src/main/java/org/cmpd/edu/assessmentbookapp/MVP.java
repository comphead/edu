package org.cmpd.edu.assessmentbookapp;

import android.content.Context;
import android.net.Uri;

import org.cmpd.edu.assessmentbookapp.common.ContextView;
import org.cmpd.edu.assessmentbookapp.common.ModelOps;
import org.cmpd.edu.assessmentbookapp.common.PresenterOps;
import org.cmpd.edu.model.AssessmentAction;

import java.util.List;

public interface MVP {

    public interface RequiredViewOps
           extends ContextView {

        void reportRequestFailure(Uri url,
                                   boolean processComplete);
        void displayResults(Uri url);
    }

    public interface ProvidedPresenterOps
           extends PresenterOps<RequiredViewOps> {
        void startProcessing();
    }

    public interface RequiredPresenterOps
           extends ContextView {
        void onProcessingComplete(Uri url,
                                  Uri pathToImageFile);
    }

    public interface ProvidedModelOps
           extends ModelOps<RequiredPresenterOps> {
         List<AssessmentAction> downloadActions(Context context,
                                              Uri url);
    }
}
