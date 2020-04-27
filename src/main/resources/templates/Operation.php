<?php

declare(strict_types=1);

namespace {operationPackage};

use {operationPackage}\Dto\{operationName}Request;
use {operationPackage}\Dto\{operationName}Response;

interface {operationName}Interface
{
    public function invoke({operationName}Request $request): {operationName}Response;
}

