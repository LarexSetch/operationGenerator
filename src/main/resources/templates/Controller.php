<?php

declare(strict_types=1);

namespace {controllerPackage}\{componentName};

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use {operationPackage}\{operationName}Interface;
use {operationPackage}\Dto\{operationName}Request;
use {operationPackage}\Dto\{operationName}Response;

final class {operationName}Controller
{
    private {operationName}Interface $operation;

    public function __construct({operationName}Interface $operation)
    {
        $this->operation = $operation;
    }

    public function actionGetList(Request $request): Response
    {
        $response = $this->operation->invoke($this->createRequest());
        //TODO implementation
    }

    private function createRequest(Request $request): {operationName}Request
    {
        return new {operationName}Request();
    }
}
