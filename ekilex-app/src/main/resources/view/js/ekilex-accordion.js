class EkiAccordion {
  constructor(element) {

    this.selectors = {
      elements: '.ekiAccordion__instance',
      toggles: '.ekiAccordion__title',
      active: '.ekiAccordion__instance--active',
      wrapper: '#word-details-area',
      content: '.ekiAccordion__content',
    };

    this.id = Math.random().toString().substr(2);
    this.resizeDebounce = 300;

    this.main = element;
    this.elements = this.main.find(this.selectors.elements);
    this.main.attr('id', `ekiAccordion-${this.id}`);
    this.debounce;
  }

  toggleElement(target) {
    target.toggleClass(this.selectors.active.substr(1));
  }

  bindElements() {
    this.elements.find(this.selectors.toggles).on('click', (e) => {
      if ($(e.target).is(this.selectors.toggles)) {
        e.preventDefault();
        this.toggleElement($(e.target).parents(`${this.selectors.elements}:first`));
      }
    });
  }

  handleResize() {
    const element = $(`#ekiAccordion-${this.id}:first`);
    if (element.length) {
      this.calculateParameters();
    } else {
      this.unbindResize();
    }
  }

  calculateParameters() {
    let titlesHeight = 0;
    const wrapper = $(`${this.selectors.wrapper}:first`);

    this.elements.find(this.selectors.toggles).each((index, element) => {
      const obj = $(element);
      titlesHeight+= obj.outerHeight();
    });

    const usableHeight = wrapper.outerHeight() - (this.main.offset().top - wrapper.offset().top) - titlesHeight;

    this.main.find(this.selectors.content).css({
      maxHeight: `${usableHeight-16}px`,
    });
  }

  unbindResize() {
    $(window).off(`resize.${this.id}`);
  }

  bindResize() {
    $(window).on(`resize.${this.id}`, () => {
      clearTimeout(this.debounce);
      this.debounce = setTimeout(() => {
        this.handleResize();
      }, this.resizeDebounce);
    });
    this.handleResize();
  }

  initialize() {
    this.bindElements();
    this.bindResize();
  }
}

/*
  jQuery plugin wrapper for EkiAccordion class.
  Can be reused accross the application;
    $(element).ekiAccordion();
*/

$.fn.ekiAccordion = function() {
  $(this).each(function(){
    const instance = new EkiAccordion($(this));
    instance.initialize();
  });
}