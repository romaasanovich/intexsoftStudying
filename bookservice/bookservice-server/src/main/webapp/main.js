(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/add-author/add-author.component.css":
/*!*****************************************************!*\
  !*** ./src/app/add-author/add-author.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "label {\n    display: inline-block;\n    float: left;\n    clear: left;\n    width: 75px;\n    text-align: left;\n}\n\ninput {\n    display: inline-block;\n    float: left;\n}\n\n.form-group {\n    line-height: 1.5;\n}\n"

/***/ }),

/***/ "./src/app/add-author/add-author.component.html":
/*!******************************************************!*\
  !*** ./src/app/add-author/add-author.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-6\">\n    <h2 class=\"text-center\">Add Author</h2>\n\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Name\" [(ngModel)]=\"author.name\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Bio\" [(ngModel)]=\"author.bio\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field>\n            <input matInput [matDatepicker]=\"picker\" placeholder=\"Birth Day\" [(ngModel)]=\"author.birthDay\">\n            <mat-datepicker-toggle matSuffix [for]=\"picker\"></mat-datepicker-toggle>\n            <mat-datepicker #picker></mat-datepicker>\n        </mat-form-field>\n    </div>\n    <div>\n        <button mat-raised-button (click)=\"addAuthor()\" color=\"primary\">Add Author</button>\n    </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/add-author/add-author.component.ts":
/*!****************************************************!*\
  !*** ./src/app/add-author/add-author.component.ts ***!
  \****************************************************/
/*! exports provided: AddAuthorComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddAuthorComponent", function() { return AddAuthorComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _entity_author_model__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../entity/author.model */ "./src/app/entity/author.model.ts");
/* harmony import */ var _author_author_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../author/author.service */ "./src/app/author/author.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AddAuthorComponent = /** @class */ (function () {
    function AddAuthorComponent(router, authorService) {
        this.router = router;
        this.authorService = authorService;
        this.author = new _entity_author_model__WEBPACK_IMPORTED_MODULE_2__["Author"]();
    }
    AddAuthorComponent.prototype.addAuthor = function () {
        this.authorService.addAuthor(this.author).subscribe(function (data) {
            alert('Author created successfully.');
        });
    };
    AddAuthorComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-add-author',
            template: __webpack_require__(/*! ./add-author.component.html */ "./src/app/add-author/add-author.component.html"),
            styles: [__webpack_require__(/*! ./add-author.component.css */ "./src/app/add-author/add-author.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _author_author_service__WEBPACK_IMPORTED_MODULE_3__["AuthorService"]])
    ], AddAuthorComponent);
    return AddAuthorComponent;
}());



/***/ }),

/***/ "./src/app/add-book/add-book.component.css":
/*!*************************************************!*\
  !*** ./src/app/add-book/add-book.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "label {\n    display: inline-block;\n    float: left;\n    clear: left;\n    width: 100px;\n    text-align: left;\n}\n\n.form-group {\n    line-height: 1.5;\n}\n"

/***/ }),

/***/ "./src/app/add-book/add-book.component.html":
/*!**************************************************!*\
  !*** ./src/app/add-book/add-book.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-6\">\n    <h2 class=\"text-center\">Add Book</h2>\n\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Name\" [(ngModel)]=\"book.name\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Description\" [(ngModel)]=\"book.description\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Price\" [(ngModel)]=\"book.price\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field>\n            <input matInput [matDatepicker]=\"picker\" placeholder=\"Publish Date\" [(ngModel)]=\"book.publishDate\">\n            <mat-datepicker-toggle matSuffix [for]=\"picker\"></mat-datepicker-toggle>\n            <mat-datepicker #picker></mat-datepicker>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field>\n            <mat-select placeholder=\"Select Publisher\" [(ngModel)]=\"book.publisher\" name=\"publisher\">\n                <mat-option *ngFor=\"let publisher of publishers\" [value]=\"publisher\">\n                    {{ publisher.name }}\n                </mat-option>\n            </mat-select>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field>\n            <mat-select placeholder=\"Select Authors\" multiple>\n                <mat-option *ngFor=\"let author of authors\" [value]=\"book.authors\">{{author.name}}</mat-option>\n            </mat-select>\n        </mat-form-field>\n    </div>\n    <div>\n        <button mat-raised-button (click)=\"addBook()\" color=\"primary\">Add Book</button>\n    </div>\n\n</div>\n\n"

/***/ }),

/***/ "./src/app/add-book/add-book.component.ts":
/*!************************************************!*\
  !*** ./src/app/add-book/add-book.component.ts ***!
  \************************************************/
/*! exports provided: AddBookComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddBookComponent", function() { return AddBookComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _entity_book_model__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../entity/book.model */ "./src/app/entity/book.model.ts");
/* harmony import */ var _book_book_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../book/book.service */ "./src/app/book/book.service.ts");
/* harmony import */ var _author_author_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../author/author.service */ "./src/app/author/author.service.ts");
/* harmony import */ var _publisher_publisher_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../publisher/publisher.service */ "./src/app/publisher/publisher.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var AddBookComponent = /** @class */ (function () {
    function AddBookComponent(router, bookService, authorService, publService) {
        this.router = router;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publService = publService;
        this.book = new _entity_book_model__WEBPACK_IMPORTED_MODULE_2__["Book"]();
        this.authorsList = new _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormControl"]();
    }
    AddBookComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.publService.getPublishers()
            .subscribe(function (data) {
            _this.publishers = data;
        });
        this.authorService.getAuthors()
            .subscribe(function (data) {
            _this.authors = data;
        });
    };
    AddBookComponent.prototype.addBook = function () {
        this.bookService.addBook(this.book)
            .subscribe(function (data) {
            alert('Book created successfully.');
        });
    };
    AddBookComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-add-book',
            styles: [__webpack_require__(/*! ./add-book.component.css */ "./src/app/add-book/add-book.component.css")],
            template: __webpack_require__(/*! ./add-book.component.html */ "./src/app/add-book/add-book.component.html")
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _book_book_service__WEBPACK_IMPORTED_MODULE_3__["BookService"], _author_author_service__WEBPACK_IMPORTED_MODULE_4__["AuthorService"],
            _publisher_publisher_service__WEBPACK_IMPORTED_MODULE_5__["PublisherService"]])
    ], AddBookComponent);
    return AddBookComponent;
}());



/***/ }),

/***/ "./src/app/add-publisher/add-publisher.component.css":
/*!***********************************************************!*\
  !*** ./src/app/add-publisher/add-publisher.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "button {\n    margin-left: 15px;\n}"

/***/ }),

/***/ "./src/app/add-publisher/add-publisher.component.html":
/*!************************************************************!*\
  !*** ./src/app/add-publisher/add-publisher.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-6\">\n    <h2 class=\"text-center\">Add Publisher</h2>\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Name\" [(ngModel)]=\"publisher.name\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n        <button mat-raised-button (click)=\"addPublisher()\" color=\"primary\">Add Publisher</button>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/add-publisher/add-publisher.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/add-publisher/add-publisher.component.ts ***!
  \**********************************************************/
/*! exports provided: AddPublisherComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddPublisherComponent", function() { return AddPublisherComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _entity_publisher_model__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../entity/publisher.model */ "./src/app/entity/publisher.model.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _publisher_publisher_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../publisher/publisher.service */ "./src/app/publisher/publisher.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AddPublisherComponent = /** @class */ (function () {
    function AddPublisherComponent(router, publisherService) {
        this.router = router;
        this.publisherService = publisherService;
        this.publisher = new _entity_publisher_model__WEBPACK_IMPORTED_MODULE_1__["Publisher"]();
    }
    AddPublisherComponent.prototype.addPublisher = function () {
        this.publisherService.addPubl(this.publisher).subscribe(function (data) {
            alert('Publisher created successfully.');
        });
    };
    AddPublisherComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-add-publisher',
            template: __webpack_require__(/*! ./add-publisher.component.html */ "./src/app/add-publisher/add-publisher.component.html"),
            styles: [__webpack_require__(/*! ./add-publisher.component.css */ "./src/app/add-publisher/add-publisher.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _publisher_publisher_service__WEBPACK_IMPORTED_MODULE_3__["PublisherService"]])
    ], AddPublisherComponent);
    return AddPublisherComponent;
}());



/***/ }),

/***/ "./src/app/add-review/add-review.component.css":
/*!*****************************************************!*\
  !*** ./src/app/add-review/add-review.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/add-review/add-review.component.html":
/*!******************************************************!*\
  !*** ./src/app/add-review/add-review.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"col-md-6\">\n    <h2 class=\"text-center\">Add Review</h2>\n\n    <div>\n        <mat-form-field class=\"example-form-field\">\n            <input matInput type=\"text\" placeholder=\"Review\" [(ngModel)]=\"review.review\"/>\n            <button mat-button *ngIf=\"value\" matSuffix mat-icon-button aria-label=\"Clear\" (click)=\"value=''\">\n                <mat-icon>close</mat-icon>\n            </button>\n        </mat-form-field>\n    </div>\n    <div>\n        <mat-form-field>\n            <mat-select placeholder=\"Select Rate\" [(ngModel)]=\"review.rate\">\n                <mat-option *ngFor=\"let item of rates\" [value]=\"item\">\n                    {{ item }}\n                </mat-option>\n            </mat-select>\n        </mat-form-field>\n    </div>\n    <div>\n        <button mat-raised-button (click)=\"addReview()\" color=\"primary\">Add Review</button>\n    </div>\n\n</div>\n\n"

/***/ }),

/***/ "./src/app/add-review/add-review.component.ts":
/*!****************************************************!*\
  !*** ./src/app/add-review/add-review.component.ts ***!
  \****************************************************/
/*! exports provided: AddReviewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddReviewComponent", function() { return AddReviewComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _book_review_book_review_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../book-review/book-review.service */ "./src/app/book-review/book-review.service.ts");
/* harmony import */ var _entity_review_model__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../entity/review.model */ "./src/app/entity/review.model.ts");
/* harmony import */ var _entity_book_model__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../entity/book.model */ "./src/app/entity/book.model.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AddReviewComponent = /** @class */ (function () {
    function AddReviewComponent(router, bookRevService, route) {
        this.router = router;
        this.bookRevService = bookRevService;
        this.route = route;
        this.rates = [1, 2, 3, 4, 5];
        this.review = new _entity_review_model__WEBPACK_IMPORTED_MODULE_3__["Review"]();
        this.review.book = new _entity_book_model__WEBPACK_IMPORTED_MODULE_4__["Book"]();
    }
    AddReviewComponent.prototype.addReview = function () {
        this.review.book.id = this.route.snapshot.queryParams.bookId;
        this.bookRevService.addReview(this.review).subscribe(function (data) { return alert('Review is added successfully!!!'); });
    };
    AddReviewComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-add-review',
            template: __webpack_require__(/*! ./add-review.component.html */ "./src/app/add-review/add-review.component.html"),
            styles: [__webpack_require__(/*! ./add-review.component.css */ "./src/app/add-review/add-review.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _book_review_book_review_service__WEBPACK_IMPORTED_MODULE_2__["BookReviewService"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"]])
    ], AddReviewComponent);
    return AddReviewComponent;
}());



/***/ }),

/***/ "./src/app/app-routing/app-routing.module.ts":
/*!***************************************************!*\
  !*** ./src/app/app-routing/app-routing.module.ts ***!
  \***************************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _book_book_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../book/book.component */ "./src/app/book/book.component.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _publisher_publisher_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../publisher/publisher.component */ "./src/app/publisher/publisher.component.ts");
/* harmony import */ var _author_author_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../author/author.component */ "./src/app/author/author.component.ts");
/* harmony import */ var _add_publisher_add_publisher_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../add-publisher/add-publisher.component */ "./src/app/add-publisher/add-publisher.component.ts");
/* harmony import */ var _add_author_add_author_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../add-author/add-author.component */ "./src/app/add-author/add-author.component.ts");
/* harmony import */ var _add_book_add_book_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../add-book/add-book.component */ "./src/app/add-book/add-book.component.ts");
/* harmony import */ var _import_import_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../import/import.component */ "./src/app/import/import.component.ts");
/* harmony import */ var _book_review_book_review_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../book-review/book-review.component */ "./src/app/book-review/book-review.component.ts");
/* harmony import */ var _add_review_add_review_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../add-review/add-review.component */ "./src/app/add-review/add-review.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};












var routes = [
    { path: 'books', component: _book_book_component__WEBPACK_IMPORTED_MODULE_2__["BookComponent"] },
    { path: 'login', component: _login_login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"] },
    { path: 'publishers', component: _publisher_publisher_component__WEBPACK_IMPORTED_MODULE_4__["PublisherComponent"] },
    { path: 'authors', component: _author_author_component__WEBPACK_IMPORTED_MODULE_5__["AuthorComponent"] },
    { path: 'publisher', component: _add_publisher_add_publisher_component__WEBPACK_IMPORTED_MODULE_6__["AddPublisherComponent"] },
    { path: 'author', component: _add_author_add_author_component__WEBPACK_IMPORTED_MODULE_7__["AddAuthorComponent"] },
    { path: 'book', component: _add_book_add_book_component__WEBPACK_IMPORTED_MODULE_8__["AddBookComponent"] },
    { path: 'import', component: _import_import_component__WEBPACK_IMPORTED_MODULE_9__["ImportComponent"] },
    { path: 'reviews', component: _book_review_book_review_component__WEBPACK_IMPORTED_MODULE_10__["BookReviewComponent"] },
    { path: 'add-review', component: _add_review_add_review_component__WEBPACK_IMPORTED_MODULE_11__["AddReviewComponent"] }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)
            ],
            exports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]
            ],
            declarations: []
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-button-row {\n    display: flex;\n    align-items: center;\n    justify-content: space-around;\n}\n\na {\n    margin: 10px;\n}\n"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n    <div class=\"col-md-offset-1\">\n        <h1 align=\"center\" colour=\"primary\">\n            Welcome to Book-service !\n        </h1>\n    </div>\n    <div>\n        <a mat-raised-button routerLink=\"/books\" color=\"primary\">Show Books</a>\n        <a mat-raised-button routerLink=\"/publishers\" color=\"primary\">Show Publishers</a>\n        <a mat-raised-button routerLink=\"/authors\" color=\"primary\">Show Authors</a>\n        <a mat-raised-button routerLink=\"/import\" color=\"primary\">Import</a>\n    </div>\n    <div>\n        <a mat-raised-button routerLink=\"/publisher\" color=\"primary\">Add Publisher</a>\n        <a mat-raised-button routerLink=\"/author\" color=\"primary\">Add Author</a>\n        <a mat-raised-button routerLink=\"/book\" color=\"primary\">Add Book</a>\n    </div>\n    <router-outlet></router-outlet>\n</div>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'Bookservice';
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _book_book_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./book/book.component */ "./src/app/book/book.component.ts");
/* harmony import */ var _app_routing_app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app-routing/app-routing.module */ "./src/app/app-routing/app-routing.module.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _book_book_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./book/book.service */ "./src/app/book/book.service.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _login_login_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./login/login.service */ "./src/app/login/login.service.ts");
/* harmony import */ var _publisher_publisher_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./publisher/publisher.component */ "./src/app/publisher/publisher.component.ts");
/* harmony import */ var _author_author_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./author/author.component */ "./src/app/author/author.component.ts");
/* harmony import */ var _publisher_publisher_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./publisher/publisher.service */ "./src/app/publisher/publisher.service.ts");
/* harmony import */ var _author_author_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./author/author.service */ "./src/app/author/author.service.ts");
/* harmony import */ var _add_publisher_add_publisher_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./add-publisher/add-publisher.component */ "./src/app/add-publisher/add-publisher.component.ts");
/* harmony import */ var _add_author_add_author_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./add-author/add-author.component */ "./src/app/add-author/add-author.component.ts");
/* harmony import */ var _add_book_add_book_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./add-book/add-book.component */ "./src/app/add-book/add-book.component.ts");
/* harmony import */ var _import_import_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./import/import.component */ "./src/app/import/import.component.ts");
/* harmony import */ var _import_import_service__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./import/import.service */ "./src/app/import/import.service.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/esm5/button.es5.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/esm5/input.es5.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/material/datepicker */ "./node_modules/@angular/material/esm5/datepicker.es5.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/esm5/select.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _book_review_book_review_component__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./book-review/book-review.component */ "./src/app/book-review/book-review.component.ts");
/* harmony import */ var _book_review_book_review_service__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./book-review/book-review.service */ "./src/app/book-review/book-review.service.ts");
/* harmony import */ var _add_review_add_review_component__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./add-review/add-review.component */ "./src/app/add-review/add-review.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




























var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
                _book_book_component__WEBPACK_IMPORTED_MODULE_3__["BookComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_7__["LoginComponent"],
                _publisher_publisher_component__WEBPACK_IMPORTED_MODULE_9__["PublisherComponent"],
                _author_author_component__WEBPACK_IMPORTED_MODULE_10__["AuthorComponent"],
                _add_publisher_add_publisher_component__WEBPACK_IMPORTED_MODULE_13__["AddPublisherComponent"],
                _add_author_add_author_component__WEBPACK_IMPORTED_MODULE_14__["AddAuthorComponent"],
                _add_book_add_book_component__WEBPACK_IMPORTED_MODULE_15__["AddBookComponent"],
                _import_import_component__WEBPACK_IMPORTED_MODULE_16__["ImportComponent"],
                _book_review_book_review_component__WEBPACK_IMPORTED_MODULE_25__["BookReviewComponent"],
                _add_review_add_review_component__WEBPACK_IMPORTED_MODULE_27__["AddReviewComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_24__["FormsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_18__["MatTableModule"],
                _angular_material_button__WEBPACK_IMPORTED_MODULE_19__["MatButtonModule"],
                _angular_material_input__WEBPACK_IMPORTED_MODULE_20__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_18__["MatIconModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_21__["BrowserAnimationsModule"],
                _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_22__["MatDatepickerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_18__["MatNativeDateModule"],
                _angular_material_select__WEBPACK_IMPORTED_MODULE_23__["MatSelectModule"]
            ],
            providers: [_book_book_service__WEBPACK_IMPORTED_MODULE_6__["BookService"], _login_login_service__WEBPACK_IMPORTED_MODULE_8__["LoginService"], _publisher_publisher_service__WEBPACK_IMPORTED_MODULE_11__["PublisherService"], _author_author_service__WEBPACK_IMPORTED_MODULE_12__["AuthorService"], _import_import_service__WEBPACK_IMPORTED_MODULE_17__["ImportService"], _book_review_book_review_service__WEBPACK_IMPORTED_MODULE_26__["BookReviewService"]],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/author/author.component.css":
/*!*********************************************!*\
  !*** ./src/app/author/author.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "table {\n    width: auto;\n}\n\n.mat-header-cell {\n    padding-left: 15px;\n}\n\n.mat-cell {\n    padding-left: 15px;\n    padding-right: 15px;\n}"

/***/ }),

/***/ "./src/app/author/author.component.html":
/*!**********************************************!*\
  !*** ./src/app/author/author.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n    <table mat-table [dataSource]=\"authors\" class=\"mat-elevation-z8\">\n\n        <ng-container matColumnDef=\"id\">\n            <th mat-header-cell *matHeaderCellDef> Id</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.id}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"name\">\n            <th mat-header-cell *matHeaderCellDef> Name</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.name}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"bio\">\n            <th mat-header-cell *matHeaderCellDef> Biography</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.bio}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"birthDay\">\n            <th mat-header-cell *matHeaderCellDef> Birth Day</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.birthDay}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"delete\">\n            <th mat-header-cell *matHeaderCellDef></th>\n            <td mat-cell *matCellDef=\"let element\">\n                <button mat-raised-button (click)=\"deleteAuthor(element)\" color=\"warn\">Delete</button>\n            </td>\n        </ng-container>\n\n        <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n        <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n    </table>\n</div>"

/***/ }),

/***/ "./src/app/author/author.component.ts":
/*!********************************************!*\
  !*** ./src/app/author/author.component.ts ***!
  \********************************************/
/*! exports provided: AuthorComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthorComponent", function() { return AuthorComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _author_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./author.service */ "./src/app/author/author.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var AuthorComponent = /** @class */ (function () {
    function AuthorComponent(router, authorService) {
        this.router = router;
        this.authorService = authorService;
        this.displayedColumns = ['id', 'name', 'bio', 'delete'];
    }
    AuthorComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.authorService.getAuthors()
            .subscribe(function (data) {
            _this.authors = data;
        });
    };
    AuthorComponent.prototype.deleteAuthor = function (author) {
        var _this = this;
        this.authorService.deleteAuthor(author)
            .subscribe(function (data) {
            _this.authors = _this.authors.filter(function (u) { return u !== author; });
        });
    };
    AuthorComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-author',
            template: __webpack_require__(/*! ./author.component.html */ "./src/app/author/author.component.html"),
            styles: [__webpack_require__(/*! ./author.component.css */ "./src/app/author/author.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _author_service__WEBPACK_IMPORTED_MODULE_2__["AuthorService"]])
    ], AuthorComponent);
    return AuthorComponent;
}());



/***/ }),

/***/ "./src/app/author/author.service.ts":
/*!******************************************!*\
  !*** ./src/app/author/author.service.ts ***!
  \******************************************/
/*! exports provided: AuthorService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthorService", function() { return AuthorService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var AuthorService = /** @class */ (function () {
    function AuthorService(http) {
        this.http = http;
    }
    AuthorService.prototype.getAuthors = function () {
        return this.http.get('http://localhost:8080/bookservice/api/authors');
    };
    AuthorService.prototype.addAuthor = function (author) {
        return this.http.post('http://localhost:8080/bookservice/api/author', author);
    };
    AuthorService.prototype.deleteAuthor = function (author) {
        return this.http.delete("http://localhost:8080/bookservice/api/author/" + author.id.toString());
    };
    AuthorService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AuthorService);
    return AuthorService;
}());



/***/ }),

/***/ "./src/app/book-review/book-review.component.css":
/*!*******************************************************!*\
  !*** ./src/app/book-review/book-review.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "table {\n    width: auto;\n}\n\n.mat-header-cell {\n    padding-left: 15px;\n}\n\n.mat-cell {\n    padding-left: 15px;\n    padding-right: 15px;\n}"

/***/ }),

/***/ "./src/app/book-review/book-review.component.html":
/*!********************************************************!*\
  !*** ./src/app/book-review/book-review.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n    <h2>All reviews</h2>\n    <div>\n        <table mat-table [dataSource]=\"reviews\" class=\"mat-elevation-z8\">\n\n            <ng-container matColumnDef=\"id\">\n                <th mat-header-cell *matHeaderCellDef> Id</th>\n                <td mat-cell *matCellDef=\"let element\"> {{element.id}}</td>\n            </ng-container>\n\n            <ng-container matColumnDef=\"user\">\n                <th mat-header-cell *matHeaderCellDef> User</th>\n                <td mat-cell *matCellDef=\"let element\"> {{element.user.username}}</td>\n            </ng-container>\n\n            <ng-container matColumnDef=\"review\">\n                <th mat-header-cell *matHeaderCellDef> Review</th>\n                <td mat-cell *matCellDef=\"let element\"> {{element.review}}</td>\n            </ng-container>\n\n            <ng-container matColumnDef=\"rate\">\n                <th mat-header-cell *matHeaderCellDef> Rate</th>\n                <td mat-cell *matCellDef=\"let element\"> {{element.rate}}</td>\n            </ng-container>\n\n            <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n            <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n        </table>\n    </div>\n    <div>\n        <br>\n        <a mat-raised-button (click)=\"goToAddReview()\" color=\"primary\">Add Review</a>\n    </div>\n</div>\n"

/***/ }),

/***/ "./src/app/book-review/book-review.component.ts":
/*!******************************************************!*\
  !*** ./src/app/book-review/book-review.component.ts ***!
  \******************************************************/
/*! exports provided: BookReviewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookReviewComponent", function() { return BookReviewComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _book_book_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../book/book.service */ "./src/app/book/book.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _book_review_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./book-review.service */ "./src/app/book-review/book-review.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var BookReviewComponent = /** @class */ (function () {
    function BookReviewComponent(router, bookService, bookReviewService, route) {
        this.router = router;
        this.bookService = bookService;
        this.bookReviewService = bookReviewService;
        this.route = route;
        this.displayedColumns = ['user', 'review', 'rate'];
    }
    BookReviewComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.selBookId = this.route.snapshot.queryParams.bookId;
        this.bookReviewService.getBookReviews(this.selBookId)
            .subscribe(function (reviews) {
            _this.reviews = reviews;
        });
    };
    BookReviewComponent.prototype.goToAddReview = function () {
        this.router.navigate(['/add-review'], {
            queryParams: { bookId: this.selBookId }
        });
    };
    BookReviewComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-book-review',
            template: __webpack_require__(/*! ./book-review.component.html */ "./src/app/book-review/book-review.component.html"),
            styles: [__webpack_require__(/*! ./book-review.component.css */ "./src/app/book-review/book-review.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _book_book_service__WEBPACK_IMPORTED_MODULE_1__["BookService"], _book_review_service__WEBPACK_IMPORTED_MODULE_3__["BookReviewService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
    ], BookReviewComponent);
    return BookReviewComponent;
}());



/***/ }),

/***/ "./src/app/book-review/book-review.service.ts":
/*!****************************************************!*\
  !*** ./src/app/book-review/book-review.service.ts ***!
  \****************************************************/
/*! exports provided: BookReviewService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookReviewService", function() { return BookReviewService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var BookReviewService = /** @class */ (function () {
    function BookReviewService(http) {
        this.http = http;
    }
    BookReviewService.prototype.getBookReviews = function (id) {
        return this.http.get("http://localhost:8080/bookservice/api/review/book/" + id);
    };
    BookReviewService.prototype.addReview = function (review) {
        return this.http.post("http://localhost:8080/bookservice/api/review/", review);
    };
    BookReviewService.prototype.delReview = function (review) {
        return this.http.delete("http://localhost:8080/bookservice/api/review/" + review.id.toString());
    };
    BookReviewService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], BookReviewService);
    return BookReviewService;
}());



/***/ }),

/***/ "./src/app/book/book.component.css":
/*!*****************************************!*\
  !*** ./src/app/book/book.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "table {\n    width: auto;\n}\n\n.mat-header-cell {\n    padding-left: 15px;\n}\n\n.mat-cell {\n    padding-left: 15px;\n    padding-right: 15px;\n}"

/***/ }),

/***/ "./src/app/book/book.component.html":
/*!******************************************!*\
  !*** ./src/app/book/book.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n    <table mat-table [dataSource]=\"books\" class=\"mat-elevation-z8\">\n\n        <ng-container matColumnDef=\"id\">\n            <th mat-header-cell *matHeaderCellDef> Id</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.id}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"name\">\n            <th mat-header-cell *matHeaderCellDef> Name</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.name}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"description\">\n            <th mat-header-cell *matHeaderCellDef> Description</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.description}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"price\">\n            <th mat-header-cell *matHeaderCellDef> Price</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.price}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"authors\">\n            <th mat-header-cell *matHeaderCellDef> Authors</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.authors.toString()}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"publisher\">\n            <th mat-header-cell *matHeaderCellDef> Publisher</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.publisher}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"publishDate\">\n            <th mat-header-cell *matHeaderCellDef> Publisher Date</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.publishDate}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"rate\">\n            <th mat-header-cell *matHeaderCellDef> Rate</th>\n            <td mat-cell *matCellDef=\"let element\">\n                <button mat-raised-button (click)=\"goToReview(element.id)\" color=\"primary\">{{element.rate}}</button>\n            </td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"delete\">\n            <th mat-header-cell *matHeaderCellDef></th>\n            <td mat-cell *matCellDef=\"let element\">\n                <button mat-raised-button (click)=\"deleteBook(element)\" color=\"warn\">Delete</button>\n            </td>\n        </ng-container>\n\n\n\n        <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n        <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n\n    </table>\n</div>\n"

/***/ }),

/***/ "./src/app/book/book.component.ts":
/*!****************************************!*\
  !*** ./src/app/book/book.component.ts ***!
  \****************************************/
/*! exports provided: BookComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookComponent", function() { return BookComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _book_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./book.service */ "./src/app/book/book.service.ts");
/* harmony import */ var _book_review_book_review_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../book-review/book-review.service */ "./src/app/book-review/book-review.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var BookComponent = /** @class */ (function () {
    function BookComponent(router, bookService, bookReview) {
        this.router = router;
        this.bookService = bookService;
        this.bookReview = bookReview;
        this.books = [];
        this.displayedColumns = ['id', 'name', 'description', 'price', 'publisher', 'authors', 'rate', 'delete'];
    }
    BookComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.bookService.getBooks()
            .subscribe(function (data) {
            _this.books = data;
        });
    };
    BookComponent.prototype.deleteBook = function (book) {
        var _this = this;
        this.bookService.deleteBook(book)
            .subscribe(function (data) {
            _this.books = _this.books.filter(function (u) { return u !== book; });
        });
    };
    BookComponent.prototype.goToReview = function (id) {
        this.router.navigate(['/reviews'], {
            queryParams: { bookId: id }
        });
    };
    BookComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-book',
            template: __webpack_require__(/*! ./book.component.html */ "./src/app/book/book.component.html"),
            styles: [__webpack_require__(/*! ./book.component.css */ "./src/app/book/book.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _book_service__WEBPACK_IMPORTED_MODULE_2__["BookService"], _book_review_book_review_service__WEBPACK_IMPORTED_MODULE_3__["BookReviewService"]])
    ], BookComponent);
    return BookComponent;
}());



/***/ }),

/***/ "./src/app/book/book.service.ts":
/*!**************************************!*\
  !*** ./src/app/book/book.service.ts ***!
  \**************************************/
/*! exports provided: BookService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BookService", function() { return BookService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var BookService = /** @class */ (function () {
    function BookService(http) {
        this.http = http;
    }
    BookService.prototype.getBooks = function () {
        return this.http.get('http://localhost:8080/bookservice/api/books');
    };
    BookService.prototype.addBook = function (book) {
        return this.http.post('http://localhost:8080/bookservice/api/book', book);
    };
    BookService.prototype.deleteBook = function (book) {
        return this.http.delete("http://localhost:8080/bookservice/api/book/" + book.id.toString());
    };
    BookService.prototype.getById = function (id) {
        return this.http.get("http://localhost:8080/bookservice/api/books/" + id);
    };
    BookService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], BookService);
    return BookService;
}());



/***/ }),

/***/ "./src/app/entity/author.model.ts":
/*!****************************************!*\
  !*** ./src/app/entity/author.model.ts ***!
  \****************************************/
/*! exports provided: Author */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Author", function() { return Author; });
var Author = /** @class */ (function () {
    function Author() {
    }
    return Author;
}());



/***/ }),

/***/ "./src/app/entity/book.model.ts":
/*!**************************************!*\
  !*** ./src/app/entity/book.model.ts ***!
  \**************************************/
/*! exports provided: Book */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Book", function() { return Book; });
var Book = /** @class */ (function () {
    function Book() {
    }
    return Book;
}());



/***/ }),

/***/ "./src/app/entity/publisher.model.ts":
/*!*******************************************!*\
  !*** ./src/app/entity/publisher.model.ts ***!
  \*******************************************/
/*! exports provided: Publisher */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Publisher", function() { return Publisher; });
var Publisher = /** @class */ (function () {
    function Publisher() {
    }
    return Publisher;
}());



/***/ }),

/***/ "./src/app/entity/review.model.ts":
/*!****************************************!*\
  !*** ./src/app/entity/review.model.ts ***!
  \****************************************/
/*! exports provided: Review */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Review", function() { return Review; });
var Review = /** @class */ (function () {
    function Review() {
    }
    return Review;
}());



/***/ }),

/***/ "./src/app/import/import.component.css":
/*!*********************************************!*\
  !*** ./src/app/import/import.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "label {\n    display: inline-block;\n    float: left;\n    clear: left;\n    width: 100px;\n    text-align: left;\n}\n\n.form-group {\n    line-height: 2;\n}\n\nbutton {\n    margin-left: 10px;\n}\n\n"

/***/ }),

/***/ "./src/app/import/import.component.html":
/*!**********************************************!*\
  !*** ./src/app/import/import.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n    <h2 class=\"text-center\">Import</h2>\n    <div>\n        <mat-form-field>\n            <mat-select placeholder=\"Select type of import\" [(ngModel)]=\"selImport\" name=\"typeImport\">\n                <mat-option *ngFor=\"let element of typeImport\" [value]=\"element\">\n                    {{ element }}\n                </mat-option>\n            </mat-select>\n        </mat-form-field>\n        <button mat-raised-button (click)=\"import()\" color=\"primary\">Import</button>\n    </div>\n</div>"

/***/ }),

/***/ "./src/app/import/import.component.ts":
/*!********************************************!*\
  !*** ./src/app/import/import.component.ts ***!
  \********************************************/
/*! exports provided: ImportComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImportComponent", function() { return ImportComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _import_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./import.service */ "./src/app/import/import.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ImportComponent = /** @class */ (function () {
    function ImportComponent(router, importService) {
        this.router = router;
        this.importService = importService;
        this.typeImport = ['xml', 'json'];
    }
    ImportComponent.prototype.import = function () {
        this.importService.import(this.selImport)
            .subscribe(function (data) {
            alert('Import is OK.');
        }, function (error) {
            alert('Import is already running!!!');
        });
    };
    ImportComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-import',
            template: __webpack_require__(/*! ./import.component.html */ "./src/app/import/import.component.html"),
            styles: [__webpack_require__(/*! ./import.component.css */ "./src/app/import/import.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _import_service__WEBPACK_IMPORTED_MODULE_2__["ImportService"]])
    ], ImportComponent);
    return ImportComponent;
}());



/***/ }),

/***/ "./src/app/import/import.service.ts":
/*!******************************************!*\
  !*** ./src/app/import/import.service.ts ***!
  \******************************************/
/*! exports provided: ImportService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImportService", function() { return ImportService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var ImportService = /** @class */ (function () {
    function ImportService(http) {
        this.http = http;
    }
    ImportService.prototype.import = function (type) {
        return this.http.post("http://localhost:8080/bookservice/api/import/" + type, type);
    };
    ImportService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], ImportService);
    return ImportService;
}());



/***/ }),

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n    <h3>Login with Username and Password</h3>\n    <table>\n        <tr>\n            <td>UserModel:</td>\n            <td>\n                <input #username type='text' name='username' value=''>\n            </td>\n        </tr>\n        <tr>\n            <td>Password:</td>\n            <td>\n                <input #password type='password' name='password'/>\n            </td>\n        </tr>\n        <tr>\n            <td colspan='2'>\n                <button (click)=\"login(username.value,password.value)\"> Login</button>\n            </td>\n        </tr>\n    </table>\n</div>\n"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _login_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./login.service */ "./src/app/login/login.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var LoginComponent = /** @class */ (function () {
    function LoginComponent(router, loginService) {
        this.router = router;
        this.loginService = loginService;
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent.prototype.login = function (username, password) {
        this.loginService.login(username, password).subscribe(function () { return console.log('success'); }, function (err) { return console.log(err); });
    };
    LoginComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _login_service__WEBPACK_IMPORTED_MODULE_2__["LoginService"]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/login/login.service.ts":
/*!****************************************!*\
  !*** ./src/app/login/login.service.ts ***!
  \****************************************/
/*! exports provided: LoginService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginService", function() { return LoginService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var LoginService = /** @class */ (function () {
    function LoginService(http) {
        this.http = http;
    }
    LoginService.prototype.login = function (username, password) {
        var body = new URLSearchParams();
        body.set('username', username);
        body.set('password', password);
        body.set('submit', 'Login');
        var options = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]().set('Content-Type', 'application/x-www-form-urlencoded')
        };
        // const frmData = new FormData();
        // frmData.append('username', username);
        // frmData.append('password', password);
        return this.http.post('http://localhost:8080/bookservice/login', body.toString(), options);
    };
    LoginService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], LoginService);
    return LoginService;
}());



/***/ }),

/***/ "./src/app/publisher/publisher.component.css":
/*!***************************************************!*\
  !*** ./src/app/publisher/publisher.component.css ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "table {\n    width: auto;\n}\n\n.mat-header-cell {\n    padding-left: 15px;\n}\n\n.mat-cell {\n    padding-left: 15px;\n    padding-right: 15px;\n}"

/***/ }),

/***/ "./src/app/publisher/publisher.component.html":
/*!****************************************************!*\
  !*** ./src/app/publisher/publisher.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n\n    <table mat-table [dataSource]=\"publishers\" class=\"mat-elevation-z8\">\n\n        <ng-container matColumnDef=\"id\">\n            <th mat-header-cell *matHeaderCellDef> Id</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.id}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"name\">\n            <th mat-header-cell *matHeaderCellDef> Name</th>\n            <td mat-cell *matCellDef=\"let element\"> {{element.name}}</td>\n        </ng-container>\n\n        <ng-container matColumnDef=\"delete\">\n            <th mat-header-cell *matHeaderCellDef></th>\n            <td mat-cell *matCellDef=\"let element\">\n                <button mat-raised-button (click)=\"deletePublisher(element)\" color=\"warn\">Delete</button>\n            </td>\n        </ng-container>\n\n\n        <tr mat-header-row *matHeaderRowDef=\"displayedColumns\"></tr>\n        <tr mat-row *matRowDef=\"let row; columns: displayedColumns;\"></tr>\n    </table>\n</div>"

/***/ }),

/***/ "./src/app/publisher/publisher.component.ts":
/*!**************************************************!*\
  !*** ./src/app/publisher/publisher.component.ts ***!
  \**************************************************/
/*! exports provided: PublisherComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PublisherComponent", function() { return PublisherComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _publisher_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./publisher.service */ "./src/app/publisher/publisher.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var PublisherComponent = /** @class */ (function () {
    function PublisherComponent(router, publisherService) {
        this.router = router;
        this.publisherService = publisherService;
        this.displayedColumns = ['id', 'name', 'delete'];
    }
    PublisherComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.publisherService.getPublishers()
            .subscribe(function (data) {
            _this.publishers = data;
        });
    };
    PublisherComponent.prototype.deletePublisher = function (publisher) {
        var _this = this;
        this.publisherService.deletePublisher(publisher)
            .subscribe(function (data) {
            _this.publishers = _this.publishers.filter(function (u) { return u !== publisher; });
        });
    };
    PublisherComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-publisher',
            template: __webpack_require__(/*! ./publisher.component.html */ "./src/app/publisher/publisher.component.html"),
            styles: [__webpack_require__(/*! ./publisher.component.css */ "./src/app/publisher/publisher.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"], _publisher_service__WEBPACK_IMPORTED_MODULE_2__["PublisherService"]])
    ], PublisherComponent);
    return PublisherComponent;
}());



/***/ }),

/***/ "./src/app/publisher/publisher.service.ts":
/*!************************************************!*\
  !*** ./src/app/publisher/publisher.service.ts ***!
  \************************************************/
/*! exports provided: PublisherService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PublisherService", function() { return PublisherService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var httpOptions = {
    headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({ 'Content-Type': 'application/json' })
};
var PublisherService = /** @class */ (function () {
    function PublisherService(http) {
        this.http = http;
    }
    PublisherService.prototype.addPubl = function (publisher) {
        return this.http.post('http://localhost:8080/bookservice/api/publisher', publisher);
    };
    PublisherService.prototype.getPublishers = function () {
        return this.http.get('http://localhost:8080/bookservice/api/publishers');
    };
    PublisherService.prototype.deletePublisher = function (publisher) {
        return this.http.delete('http://localhost:8080/bookservice/api/publisher' + '/' + publisher.id.toString());
    };
    PublisherService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])(),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], PublisherService);
    return PublisherService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/INTEXSOFT/roman.asanovich/intexsoftStudying/bookservice/bookservice-client/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map