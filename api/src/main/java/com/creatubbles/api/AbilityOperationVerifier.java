package com.creatubbles.api;

import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.model.ObjectType;
import com.creatubbles.api.model.Operation;

/**
 * Created by Janek on 04.11.2016.
 */

public final class AbilityOperationVerifier {

    public static void verify(ObjectType objectType, Operation operation) {
        if (objectType == null || operation == null) {
            throw new InvalidParametersException("Ability and operation can't be null!");
        }
        switch (objectType) {
            case CREATION:
                verifyCreation(operation);
                break;
            case GALLERY:
                verifyGallery(operation);
                break;
            case USER:
                verifyUser(operation);
                break;
            case ACCOUNT:
                verifyAccount(operation);
                break;
            case COMMENT:
                verifyComment(operation);
                break;
            case BUBBLE:
                verifyBubble(operation);
                break;
            default:
                throw new InvalidParametersException("Invalid objectType!");
        }

    }

    private static void verifyCreation(Operation operation) {
        if (operation != Operation.EDIT &&
                operation != Operation.REPORT &&
                operation != Operation.SEE_REFLECTION_TEXT &&
                operation != Operation.SEE_REFLECTION_VIDEO &&
                operation != Operation.SHARE) {
            throw new InvalidParametersException("Invalid operation for Creation object!");
        }
    }

    private static void verifyGallery(Operation operation) {
        if (operation != Operation.EDIT &&
                operation != Operation.SHARE &&
                operation != Operation.SUBMIT_TO) {
            throw new InvalidParametersException("Invalid operation for Gallery object!");
        }
    }

    private static void verifyUser(Operation operation) {
        if (operation != Operation.EDIT &&
                operation != Operation.SWITCH &&
                operation != Operation.SWITCH_WITHOUT_PASSWORD &&
                operation != Operation.SHARE &&
                operation != Operation.CUSTOMIZE) {
            throw new InvalidParametersException("Invalid operation for User object!");
        }
    }

    private static void verifyAccount(Operation operation) {
        if (operation != Operation.EDIT &&
                operation != Operation.SWITCH &&
                operation != Operation.SHARE &&
                operation != Operation.CUSTOMIZE &&
                operation != Operation.SHARE_FULLY) {
            throw new InvalidParametersException("Invalid operation for Account object!");
        }
    }

    private static void verifyComment(Operation operation) {
        if (operation != Operation.REPORT &&
                operation != Operation.DECLINE &&
                operation != Operation.APPROVE &&
                operation != Operation.DELETE) {
            throw new InvalidParametersException("Invalid operation for Comment object!");
        }
    }

    private static void verifyBubble(Operation operation) {
        if (operation != Operation.DESTROY) {
            throw new InvalidParametersException("Invalid operation for Bubble object!");
        }
    }

}
