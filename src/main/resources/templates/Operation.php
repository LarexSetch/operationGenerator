<?php

declare(strict_types=1);

namespace {package}\{operationName};

use {package}\{operationName}\Dto\{operationName}Request;
use {package}\{operationName}\Dto\{operationName}Response;

interface {interfaceName}
{
    public function invoke({operationName}Request $request): {operationName}Response;
}

